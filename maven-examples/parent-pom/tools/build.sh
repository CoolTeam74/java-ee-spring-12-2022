#!/bin/bash
cd ../
./mvnw \
  -Drepo.username=$MVN_REPO_USERNAME \
  -Drepo.password=$MVN_REPO_PASSWORD \
  -Drepo.snapshot.url=$MVN_REPO_SHANPSHOT_URL \
  -Drepo.release.url=$MVN_REPO_RELEASE_URL \
  -Drepo.central.url=$MVN_CENTRAL_URL \
  clean deploy