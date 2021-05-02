#!/usr/bin/env bash

set -e

docker pull guneykanince/useraccountapi:latest
docker run -e "SPRING_PROFILES_ACTIVE=development" -p 8080:8080 -d --restart always -t guneykanince/useraccountapi:latest