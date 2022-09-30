pipeline {
    agent any
    stages {
        stage('maven build'){
            steps{
                bat 'mvn clean install'
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
					"pattern": "**/*.war",
					"target": "Projects/%JOB_NAME%/"
					}
				]
			}''',

        )
        }
   }
