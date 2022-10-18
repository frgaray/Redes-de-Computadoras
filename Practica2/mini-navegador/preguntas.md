## Entregables

- Un documento (pdf, txt o md) con la respuesta a los siguientes incisos:
  1. ¿Qué es un UserAgent?
  
  Es una aplicación que funciona como cliente en un protocolo. Pueden ser navegadores, celulares o cualquier equipo y cualquier aplicación que se conecte a una red como cliente.
  2. Menciona 8 headers de HTTP y la utilidad que aportan
  * "Host:" El lugar donde se encuentra el recurso.
  * "Connection: close" el navegador le indica al servidor que cierre la conexión después de mandar el recurso solicitado. 
  * "User-agent:" Especifica el UserAgent (véase 1.) desde el cual se hace la petición.
  * "Accept-language:" Indica que el usuario tiene alguna preferencia por algún lenguaje, con el motivo de que en caso de que el recurso se encuentre en este lenguaje le sea otorgada esa versión del recurso.
  * "Date:" Indica la fecha en el que fue creado y enviado **el mensaje HTTP de respuesta**, no la fecha de creación del recurso dado.
  * "Server:" Especifica el tipo de servidor que realiza el mensaje de respuesta, similar a "User-agent:" pero para el servidor, no el cliente.
  * "Last-Modified:" Indica la fecha en la que el recurso brindado fue creado o modificado por última vez, lo último que haya ocurrido.
  * "Keep-Alive:" Le da pistas al cliente de cómo mantener viva la comunicación con el servidor. Se le dan dos parámetros, `timeout` y `max`. `timeout` es el tiempo máximo de espera que el servidor puede garantizar que esperará solicitudes del cliente, es decir, después del valor de `timeout` puede ocurrir que se cierre la conexión. Para `max`, es el máximo número de peticiones que se pueden hacer durante esa conexión antes de que se cierre.
  
  3. ¿Qué es un web crawler y para qué lo usarías?
  
  Son bots que recorren la web analizando el contenido de todas y cada una de las páginas que visitan y lo almacenan en bases de datos.
  Con la información almacenada y según lo que le haya indicado que me gustaría o me interesaría que recabara de las páginas, podría obtener información de cualquier cosa que hubiera en la web. Es así como funcionan los motores de búsqueda de Google, siempre proporcionando resultados actualizados de cualquier búsqueda que deseemos hacer.

Extras:

  4. Investiga el uso de la herramienta hydra y menciona alguno de sus usos
  
  Hydra es una herramienta de auditoría de inicio de sesión que trabaja con múltiples tareas en paralelo, soporta una gran variedad de protocolos. Es muy rápido y flexible, y los nuevos módulos son fáciles de agregar. Esta herramienta permite a los investigadores y consultores de seguridad mostrar lo fácil que sería obtener acceso no autorizado a un sistema de forma remota.
    Usos:
    - Ataques SSH: se usa para realizar ataques por diccionarios a protocolos comunes
    - Ataque a un formulario web
    - Ataque FTP
    
  5. ¿Qué es el phishing? ¿cómo podrías evitarlo?
  
  El phishing es una estrategia que se usa normalmente para robar información de alguien en particular por medio del engaño. Un ejemplo es cuando se le manda un url de un sitio que parece confiable o familiar a la víctima, pero este sitio es falso y toda la información brindada le es otorgada al que hace el phishing.
  
  La mejor manera de evitarlo es poniendo mucha atención de dónde obtenemos el url que abrimos, que la apariencia del sitio no sea sospechosa y que se use algún protocolo seguro como HTTPS. Para los sitios que sea posible, también habilitar la autenticación en dos pasos.
  
  6. Si algún atacante malicioso se apoderara de los datos de todas tus peticiones GET de HTTP, ¿qué información podría obtener e inferir de tí?
  
  Se apoderaría de toda la información que le puedan brindar mis headers. Por ejemplo mi UserAgent o incluso una aproximación de mi ubicación.
  

