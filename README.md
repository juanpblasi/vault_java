- Al armar los objetos en la base, se pueden colocar datos dummy en las tablas.
- Construir los endpoints API Rest que permitan realizar las siguientes operaciones
  del objeto Employee. Estas operaciones se realizaran solo sobre la entidad
  Employee, no es necesario que se envíe u obtenga toda la jerarquía de objetos.
  o Insertar
  § Colocar el Id por secuencia o similar de BD
  o Modificar //PutMapping
  o Eliminar
  o Consultar 1 empleado (Por ID)
  § Solo los datos de la entidad Employee
- Construir un Endpoint que permita consultar una lista de objetos Employee
  o La lista de Objetos debe ser devuelta con toda la jerarquía de objetos
  § Departments, Jobs, JobHistory, Locations, Countries, Regions
  o Que permita filtrar por los siguientes valores
  § JOB_ID
  § MANAGER_ID
  § LAST_NAME
  o Debe recibir parámetros que permitan la paginación de la lista de
  resultados.
  o Ordenar la lista de resultados por HireDate ascendente (realizar el
  ordenamiento desde JAVA, en vez de en la query a la base de datos.)
- Construir un Endpoint que permita insertar entidades de tipo Departments
  o Enviar en los datos del Department el dato LocationId.
  o Agregar una validación que determine el promedio de salario de todos los
  empleados pertenecientes a todos los Department cuyo LocationId sea el
  mismo del objeto que se esta intentando insertar.
  § Si dicho promedio es mayor a 1000 y la fecha actual determina
  que nos encontramos del 1 al 14 (primeras 2 semanas del mes), en
  ese caso denega la inserción del Department. Si es menor a 1000
  la permite
  § En caso de que nos encontremos después de las 2 primeras
  semanas del mes (del 15 en adelante) entonces si el promedio es
  mayor a 1500 denega la inserción, caso contrario la permite.