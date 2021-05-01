#!/usr/bin/env bash

set -e

IMAGE_NAME="app/useraccounts"

docker run -e "SPRING_PROFILES_ACTIVE=development" -p 8080:8080 -d "$IMAGE_NAME"
