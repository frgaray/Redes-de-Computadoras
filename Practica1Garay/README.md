# Práctica 1 - SMTP
## Clojure 
### Editores recomendados:
- Emacs
- VSCode con plugin Calva
- Atom (no es bueno)

### IDE:
- IntelliJ con plugin Cursive

### Ejecución
Puedes ejecutar cualquier función que reciba un parámetro si abres una terminal en la raíz de esta carpeta y escribes:

```bash
$ clj -X namespace/funcion
```

La siguiente llamada ejecutará la función `hola` del namespace 
`hello`:

```bash
$ clj -X hola/hello
```

## Envío de correos 
1. Añadiremos [Postal](https://github.com/drewr/postal) como dependencia de este proyecto. (revisar `deps.edn`, esto ya se hizo).
2. Habilitaremos las aplicaciones menos seguras en la configuración de tu cuenta de gmail, recuerda revertir este cambio al terminar.
3. Crearemos una función que envíe correos usando postal (ya está creada, revisar el namespace `send-email` y probarla con sus correos).


## Ejercicios de laboratorio

Se recomienda ampliamente replicar lo realizado en el laboratorio para asegurarse de que tienen todo funcionando. 

1. Visitar alguna página web que no utilice SSL (HTTPs) y visitarla (por ejemplo [NeverSSL](http://silvershinyshiningtreasure.neverssl.com/online/)).
2. En linux con el comando `ifconfig` en la termianl se pueden ver las interfaces de red de la computadora.
  Se debe identificar la interaz de red de su adaptador con acceso a internet, una vez identificado, comenzar la captura de tráfico usando Wireshark, si no se identifica la interfaz de red, se puede utilizar `any`.
3. En el navegador, recargar la página.
4. Detener la captura en Wireshark.
5. Aplicar como filtro en Wireshark: `http.host contains abcd.xyz` siendo `abcd.xyz` el dominio de la página que visitaron.
6. Copiar el contenido HTML capturado y enviarlo a ustedes mismos por email usando la función de Clojure.

## Ejercicios de tarea

Esta práctica es individual.

Subir un documento (.pdf, .md o .txt) **legible** con las respuestas a los ejercicios 1 a 3
 
1. Encontrar algún otro dominio que no utilice SSL y responder a las siguientes preguntas:
   - ¿Cuál es el dominio que encontraste?
   	info.cern.ch
   - ¿Es un problema que el sitio no utilice HTTPs?
   	Diría que no ya que no solicita información personal de ningún tipo. Supongo que es capaz de obtener algunos datos como mi IP y rastrear mi zona pero dudo que los dueños del sitio lo hagan ya que por lo que investigué se trata del primer sitio web de la historia, en posesión del CERN. Por lo que dudo que sea inseguro.
   - ¿HTTPs debería ser utilizado **siempre**? ¿por qué?
   	Se debería procurar usarlo siempre, pero si se piensa hacer una página web con logins o algún método de autenticación y encima se piensa usar redes wifi muy 						antiguas, quizás se podría valorar y considerar qué información y a quién es posible que se la estén cediendo. Pero en general, por mayores temas de seguridad y gracias a que el hardware cada vez es mejor, sí deberíamos aspirar a usar siempre HTTPs.
   	
2. Excluyendo a Gmail, ¿qué otros servicios de correo electrónico existen que permiten usar sus servidores para enviar correos desde un cliente propio?
   Menciona al menos uno y sus parámetros de configuración.
   	El otro servicio de correo electrónico que nos lo permite es Amazon Simple Email Service.
   	Sus parámetros de configuración usando postal.core son:
   	(send-message {:user " ; Tu usuario
   		       "
 		       :pass " ; Tu contraseña
 		       "
                       :host "email-smtp.us-east-1.amazonaws.com"
                       :port 587}
               {:from "  ; La dirección de correo de origen
                "
                :to "  ; La dirección de correo de destino
                "
                :subject "  ; El asunto del mail
                "
                :body "  ; El cuerpo del mail
                "})
                
3. ¿Cuál es el puerto por defecto de escucha de HTTPs y cuál es el de SMTP? ¿por qué crees que Gmail cambió el puerto por defecto?
	El de HTTPs es el 443.
	Para el SMTP, según su RFC correspondiente (5321<sup>[1]</sup>), en el apartado 4.5.4.2 se dice que es el puerto 25. Pero en otras páginas web encontré que se usan los puertos 25, 465, 587 ó 2525, pero que para usos actuales sólo deberíamos considerar el uso de los puertos 587 ó 2525.
	
	Porque Gmail nos sugiere que para enviar correos desde una aplicación creada por nosotros debemos usar el servicio STMP de retransmisión, ya que autentifica usando nuestra dirección IP<sup>[2]</sup>.
	Además no es buena idea usar el puerto 25 (que es el estándar) ya que los ISP tienden a bloquear este puerto para reducir la cantidad de spam que se transmite<sup>[3]</sup>. Por lo que lo mejor es usar el puerto 587 o su puerto espejo 2525.
	
[1] https://www.rfc-editor.org/rfc/rfc5321
[2] https://support.google.com/a/answer/176600?hl=en
[3] https://www.mailgun.com/blog/email/which-smtp-port-understanding-ports-25-465-587/  ; En el apartado `Which SMTP port should I use?`

### Extra
Enviar un email a `ulises.ssb@ciencias.unam.mx` utilizando la función que envía correos mostrando alguna 
característica que te parezca interesante de Clojure junto con el código que lo generó. Puedes buscar en la CheatSheet del lenguaje para inspirarte.

Ejemplo de cuerpo de correo:

"Me interesaron los conjuntos y que pueden ser usados como predicado:

 Un conjunto es:

 #{},  #{"elemento"} o #{1 "hola" "adios" 3 20}

 Y se puede usar así:

(#{"elemento"} "a") ;; => false

(#{"elemento"} "elemento") ;; => true

Aquí genero un conjunto con los primeros n números de fibbonacci pares:

(defn fibbonacci [n]

;; tu código

)

(set (take 6 (filter even? (map fibbonacci (range)))))

;; => #{2 8 34 144 610 2584}
 "
