# restweather
Microservicio RESTFUL para Openweather


1) Ejecutar desde el archivo: WeatherApp
2) Conectarse a través de http://localhost:8080
3) Se pueden realizar la siguientes consultas por medio de las siguientes URLS
  a) Para el clima de la cuidad solicitada http://localhost:8080/api/clima/{cuidad}
  b) Para el clima de la con una unidad de medida solicitada http://localhost:8080/api/clima/{cuidad}/{units}
    b.1 Fahrenheit usar units=imperial
    b.2 Celsius usar units=metri
    b.3 Kelvin es la unidad que trae por defecto
  c) Para obtener el clima actual http://localhost:8080/api/actual/{pais}/{cuidad}
  d) Para obtener el clima semanal http://localhost:8080/api/semanal/{pais}/{cuidad}
