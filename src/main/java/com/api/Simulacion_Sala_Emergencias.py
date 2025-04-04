import simpy
import random
import numpy as np
import matplotlib.pyplot as plt


SEED = 101
random.seed(SEED)

# Definicion de los parametros de la simulacion 
NUM_DOCTORES = 3 
NUM_ENFERMERAS = 2  
NUM_PACIENTES = 18  
INTERVALO_LLEGADA = 3  
TIEMPO_TOTAL = 180  
TIEMPO_ATENCION = (20, 35)  

tiempos_espera = []  
tiempos_evaluacion = []  
tiempos_atencion = []  
personas_atendidas = [] 

# Definicion de los parametros de los pacientes 
class Paciente:
    def __init__(self, nombre, llegada):
        self.nombre = nombre
        self.llegada = llegada
        self.prioridad = 5  


class SalaEmergencias:
    def __init__(self, env, num_doctores, num_enfermeras):
        self.env = env
        self.doctores = simpy.PriorityResource(env, capacity=num_doctores)
        self.enfermeras = simpy.Resource(env, capacity=num_enfermeras)

    # Proceso para determinar la complejidad de la emergencia
    def evaluar_paciente(self, paciente):
        """La enfermera asigna una prioridad al paciente (1: urgente, 5: menos grave)."""
        tiempo_evaluacion = random.uniform(1, 3)
        yield self.env.timeout(tiempo_evaluacion)  
        tiempos_evaluacion.append(tiempo_evaluacion)  

        paciente.prioridad = random.randint(1, 5)

        print(f'{paciente.nombre} ha sido evaluado en {self.env.now:.2f} minutos con prioridad {paciente.prioridad}')

    # Proceso para atender al paciente
    def atender_paciente(self, paciente):
        """El doctor atiende al paciente en la sala de electrocardiograma."""
        tiempo_atencion = random.randint(*TIEMPO_ATENCION)
        yield self.env.timeout(tiempo_atencion)  
        tiempos_atencion.append(tiempo_atencion)  

        personas_atendidas.append((self.env.now, len(personas_atendidas) + 1))

        print(f'{paciente.nombre} ha comenzado a ser atendido en {self.env.now:.2f} minutos')


def paciente(env, nombre, sala):
    """Simula el flujo de un paciente en la sala de emergencias."""
    llegada = env.now
    paciente_obj = Paciente(nombre, llegada)  

    print(f'{paciente_obj.nombre} ha llegado a la sala en {llegada:.2f} minutos')

    with sala.enfermeras.request() as req:
        yield req
        yield env.process(sala.evaluar_paciente(paciente_obj))

    with sala.doctores.request(priority=paciente_obj.prioridad) as req:
        yield req
        espera = env.now - llegada
        tiempos_espera.append(espera)

        yield env.process(sala.atender_paciente(paciente_obj))

# Contador de pacientes
def generar_pacientes(env, sala, intervalo, num_pacientes, tiempo_total):
    """Genera pacientes con un límite de tiempo de simulación y cantidad máxima de pacientes."""
    paciente_contador = 0
    while paciente_contador < num_pacientes and env.now < tiempo_total:
        yield env.timeout(random.expovariate(1.0 / intervalo))
        env.process(paciente(env, f'Paciente{paciente_contador}', sala))
        paciente_contador += 1


env = simpy.Environment()
sala = SalaEmergencias(env, NUM_DOCTORES, NUM_ENFERMERAS)
env.process(generar_pacientes(env, sala, INTERVALO_LLEGADA, NUM_PACIENTES, TIEMPO_TOTAL))
env.run(until=TIEMPO_TOTAL)

print(f'Tiempo promedio de espera: {np.mean(tiempos_espera):.2f} minutos')
print(f'Tiempo promedio de evaluación: {np.mean(tiempos_evaluacion):.2f} minutos')
print(f'Tiempo promedio de atención: {np.mean(tiempos_atencion):.2f} minutos')

print(f'Desviación estándar del tiempo de espera: {np.std(tiempos_espera):.2f} minutos')
print(f'Desviación estándar del tiempo de evaluación: {np.std(tiempos_evaluacion):.2f} minutos')
print(f'Desviación estándar del tiempo de atención: {np.std(tiempos_atencion):.2f} minutos')

# Graficar matplot del número de pacientes atendidos / tiempo
tiempos = [x[0] for x in personas_atendidas]
num_pacientes = [x[1] for x in personas_atendidas]

plt.plot(tiempos, num_pacientes, marker='o')
plt.xlabel('Tiempo (minutos)')
plt.ylabel('Número de pacientes atendidos')
plt.title('Número de pacientes atendidos vs. tiempo')
plt.grid(True)
plt.show()