pipeline {
    environment {
        registry = "sandeep4642/hello-spring-boot-war"    
        registryCredential = 'dockerhub'
        dockerImage = ''
      }
    agent any
    stages {
        stage('maven build'){
            agent { label "master"}
            steps{
                bat 'mvn -DskipTests clean package'
                stash includes: 'target/*.war', name: 'targetfiles'
            }
        }
        stage('Building Docker image') {
            agent { label "docker-slave"}
            steps{
              script {
                unstash 'targetfiles'
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
              }
            }
        
        }
        stage('Deploy push') {
            agent { label "docker-slave"}
            steps{
              script {
                docker.withRegistry( '', registryCredential ) {
                  dockerImage.push()
                }
              }
            }
          }
          stage('Deploy to docker-Server1'){
            agent { label "docker-slave"}
            steps{
                sh 'ansible-playbook deploy_docker.yaml --extra-vars "job_name=$JOB_NAME" --extra-vars "build_no=$BUILD_NUMBER"'
            }
        }
        stage('Remove Unused docker image') {
            agent { label "docker-slave"}
            steps{
              sh "docker rmi $registry:$BUILD_NUMBER"
            }
          }
        }  
        }
