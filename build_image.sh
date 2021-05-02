#!/usr/bin/env bash

set -e

IMAGE_NAME="guneykanince/useraccountapi"

docker build --tag "$IMAGE_NAME" .
