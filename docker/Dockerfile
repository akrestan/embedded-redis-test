# fails
#FROM czdcm-quay.lx.ifortuna.cz/build-images/ubi8:latest
# works
FROM czdcm-quay.lx.ifortuna.cz/build-images/ubi9:latest

ARG VERSION=1.0
ARG user=jenkins
ARG group=jenkins
ARG uid=1995
ARG gid=1995
LABEL Description="jenkins user embedded Redis tester" Vendor="AKR" Version="$version"
RUN set -ex &&\
    dnf install -y  --setopt=tsflags=nodocs java-17-openjdk-headless java-17-openjdk-devel java-17-openjdk shadow-utils less procps-ng tar gzip curl-devel expat-devel gettext openssl-devel zlib-devel gcc perl-ExtUtils-MakeMaker bzip2 make git git-lfs
RUN set -ex &&\
    groupadd -g ${gid} ${group} &&\
    useradd -c "Jenkins user" -d /home/${user} -u ${uid} -g ${gid} -m ${user}
USER ${user}
WORKDIR /home/${user}
ADD ./build/docker/emb-redis-app.jar /home/${user}/emb-redis-app.jar
#ENTRYPOINT ["tail", "-f", "/dev/null"]
ENTRYPOINT ["bash", "-c", "java -jar emb-redis-app.jar"]