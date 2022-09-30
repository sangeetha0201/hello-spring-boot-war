pipeline {
    agent any
    stages {
        stage('maven build'){
            steps{
                bat 'mvn clean install'
                bat 'ren /target/*.war /target/${JOB_NAME}-${BUILD_NUMBER}.war'
            }
        }
        }
  post {
    always {
        rtUpload (
			serverId: 'jfrog-creds',
			spec: '''{
				"files": [
					{
					"pattern": "**/${JOB_NAME}-${BUILD_NUMBER}.war",
					"target": "Projects/${JOB_NAME}/"
					}
				]
			}''',
 
        )
        }
   }
}
