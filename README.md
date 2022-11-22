# SpringSecurityWithOauthServer


here we have implemented spring oauth server using spring security.
Assumed client application has registered with server(resource server ) and added their dummy values in authorization server using ClientDetailsServiceConfigurer
here given client id and client secrete and scope and grant type has password .

![image](https://user-images.githubusercontent.com/115841974/203217961-5b87b465-0d69-4617-9e6d-5ec74c8c9fe2.png)

![image](https://user-images.githubusercontent.com/115841974/203217987-91306e82-bb93-461b-b9b9-312e715e0b53.png)


using the access token able to add data in database and retreieved data from database by adding resource server and permitting the controller uri 

![image](https://user-images.githubusercontent.com/115841974/203218137-0062e9ed-0bfb-4cfa-a66c-bd1d27ef796a.png)

![image](https://user-images.githubusercontent.com/115841974/203218156-9cea9390-c405-4dc2-b22b-7339a3daba71.png)

![image](https://user-images.githubusercontent.com/115841974/203218170-31297b6e-5ccd-4e2a-a0af-2a97e8410c6c.png)


above process has be done using grant type as password but when am trying to use grant type as authorization code to get access token its fialing at login page itself 
![image](https://user-images.githubusercontent.com/115841974/203218681-095ceaa4-3366-4b26-b79d-8f2c365473b7.png)

if i provided authrization code in grant type it will due to not supply of code am getting invalid request 

![image](https://user-images.githubusercontent.com/115841974/203218709-1056962d-0849-4c71-92b4-86e12450ca6b.png)
![image](https://user-images.githubusercontent.com/115841974/203218971-d3e9b720-2def-4cf5-997d-beb3fdaa81b2.png)


any help would be appreciated!!
