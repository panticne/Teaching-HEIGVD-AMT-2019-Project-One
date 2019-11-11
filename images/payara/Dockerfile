FROM payara/server-full

ADD drivers/ ${PAYARA_DIR}/glassfish/lib/
ADD scripts/post-boot-commands.asadmin /opt/payara/config/post-boot-commands.asadmin
ADD deploy/Project-One.war /tmp/Project-One.war

