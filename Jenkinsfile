   pipeline {
    agent none
    stages {
        stage('maven build'){
            agent any
            steps{
                sh 'mvn -DskipTests clean  package'
                sh 'mv ${WORKSPACE}/target/*.war ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war'
            }
        }
        stage('upload war to s3'){    
            agent any  
            steps{
                s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'sangeetha-jenkins-war', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, sourceFile: 'target/hello-spring-boot-war-${BUILD_NUMBER}.war', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 's3-uploads', userMetadata: []
            }
        }
        stage('deploy to tomcatserver1'){  
            agent {
                label 'jenkins-slave1'
              }   
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-creds', path: '', url: 'http://15.206.157.93:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
