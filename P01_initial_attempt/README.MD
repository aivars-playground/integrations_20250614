KEYCLOAK
=

https://www.keycloak.org/getting-started/getting-started-docker
```shell
docker run -p 8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.2.5 start-dev
```

```
create "my-realm"
create client
   openidconnect, id: my-client, name: Demo client 
   all urls - http://localhost:8081
   redirects  http://localhost:8081/*
   web origin *
   
   add my_client_admin, my_client_user
   add my_realm_admin, my_ralm_user    (link to client admin/user)
   add my_superuser-1, my_user-1,     (link to realm admin/user, set password: password)
   

apis:
http://localhost:8080/realms/my-realm/.well-known/openid-configuration   
```

* kc export does not work!!!!
* https://github.com/keycloak/keycloak/issues/33800
use [docker-compose.yml](docker-compose.yml)
and 
```shell
docker compose exec keycloak /opt/keycloak/bin/kc.sh export --dir /opt/keycloak/data/import/ --realm=my-realm --users=same_file --db-url 'jdbc:h2:file:/opt/keycloak/data/h2/keycloakdb;NON_KEYWORDS=VALUE;AUTO_SERVER=true'
```
