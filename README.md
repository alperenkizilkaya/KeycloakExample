# KeycloakExample
Integration of Keycloak with Spring Boot API

		https://www.keycloak.org/archive/downloads-13.0.1.html 

		"Distribution powered by WildFly" yazan kısımdan zip olarak indir, istediğin yerde zip'ten çıkar

		keycloak-13.0.1\bin dizinine git

		ayağa kaldır: cmd ->
				standalone.sh -Djboss.socket.binding.port-offset=100
				
				**for mac -> chmod +x standalone.sh
					     ./standalone.sh -Djboss.socket.binding.port-offset=100

		adres:
			http://localhost:8180/auth
			username: admin 
			password: admin 
					bilgiler ile giriş yap

		Solda Master yazan yerine üzerine gelip "Add realm"a tıkla
		Oluşturulan yeni realm içinde "Configure" sekmesinde
			 "Clients" sekmesinde yeni bir client oluştur (sadece client ID kısmına isim yazmak yeterli)
			 "Roles" sekmesine gidip yeni rol oluştur. (isim vermek yeterli)

		"Manage" sekmesinde 
			"Users" sekmesine git ve yeni user ekle (username vermek yeterli)
			save ettikten sonra yukarıya gelen sekmelerden "Credentials" sekmesinden password belirle
			"Role Mapping" sekmesinde oluşuturulan kullanıcıya atamak istediğin rolü belirle (assigned roles tarafına atılacak)

		realm setting -> endpoints -> OpenId Endpoint Configuration (http://localhost:8180/auth/realms/SpringBootKeycloak/.well-known/openid-configuration)

		postman -> url : GET http://localhost:8180/auth/realms/SpringBootKeycloak/protocol/openid-connect/token
			   authorization sekmesi
			   type : OAuth 2.0
			   grant type: password credentials
			   access token url : http://localhost:8180/auth/realms/SpringBootKeycloak/protocol/openid-connect/token
			   clientId: login-app
			   username (user1)
			   password (1234)
			   scope: openid
			get new access token
			jwt.io'dan tokeni kopyala yapıştır yapıp ayrıntılarına bakabiliriz

__________________________________________________________________________________________________
Spring boot configuration 
_________________________

		spring-boot-configuration -> 
						config package'ında SecurityConfig.class oluştur gerekli ayarlamaları yap
						controller içinde endpointlerin altına @RolesAllowed("user") gibi belirt

		postman -> url : GET http://localhost:9090/employees
			   authorization sekmesi
			   type : OAuth 2.0
			   grant type: password credentials
			   access token url : http://localhost:8180/auth/realms/SpringBootKeycloak/protocol/openid-connect/token
			   clientId: login-app
			   username (user1 for user role)     (user99 for admin role)
			   password (1234)
			   scope: openid
			get new access token   -> (jwt.io'dan tokeni kopyala yapıştır yapıp ayrıntılarına bakabiliriz)
			use token
			send request

