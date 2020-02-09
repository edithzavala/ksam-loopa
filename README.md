# KSAM-loopa
(**K**nowledge-driven **S**elf-**A**daptive **M**onitoring)

### Description:
An implementation of an adaptive feedback MAPE-K loop using the HAFLoop framework (https://github.com/edithzavala/loopa).

This implementation is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### Getting started:
- Install docker (https://www.docker.com/)
- Get KSAM latest Docker image ($ docker pull edithzavala/ksam:latest)
- Run KSAM ($ docker run -p 8080:8080 edithzavala/ksam /application.json)
  * Note: /application.json is a mandatory configuration file placed at src/main/resources

### Usage:

- API description at https://httpksam.docs.apiary.io/#

**Main contact:** Edith Zavala (<zavala@essi.upc.edu>)
