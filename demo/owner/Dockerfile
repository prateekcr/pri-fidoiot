# Copyright 2020 Intel Corporation
# SPDX-License-Identifier: Apache 2.0

FROM ubuntu:20.04
ARG _JAVA_OPTIONS
ENV _JAVA_OPTIONS=${_JAVA_OPTIONS}
RUN apt-get update && apt-get install -y openjdk-11-jdk libsofthsm2 softhsm softhsm-common opensc wget

# Configuring softHSM and JVM provider.
COPY java.security /etc/java-11-openjdk/security/
COPY pkcs11.cfg /etc/softhsm/
RUN chmod 777 /var/lib/softhsm/tokens && chmod 777 /etc/softhsm/pkcs11.cfg && chmod 777 /usr/lib/softhsm/libsofthsm2.so
RUN softhsm2-util --init-token --slot 0 --label "PRI-Token" --so-pin 123456 --pin 123456

# Import owner keys into PKCS11 keystore
COPY owner_pri.p12 .
RUN keytool -importkeystore -deststorepass 123456 -destkeystore NONE -srckeystore owner_keystore.p12 -deststoretype PKCS11 -srcstoretype PKCS12 -srcstorepass 123456 -alias owner_pri

RUN useradd -ms /bin/bash fidoiotowner
# USER fidoiotowner
WORKDIR /home/fidoiotowner/
RUN mkdir lib target
COPY ./lib ./lib/
COPY ./target ./target/
COPY owner.jar .
CMD ["java", "-jar", "owner.jar"]
