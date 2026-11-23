pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    triggers {
        // Detecte un nouveau push sur GitHub (verification toutes les 2 minutes)
        pollSCM('H/2 * * * *')
    }

    stages {
        stage('Recuperer le projet depuis GitHub') {
            steps {
                git branch: 'main', url: 'https://github.com/Moemen00/DevOps.git'
            }
        }

        stage('Tests unitaires') {
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Livrable (target)') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        failure {
            mail to: 'TON_EMAIL@gmail.com',
                 subject: "Build ECHOUE : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "La construction a echoue.\nDetails : ${env.BUILD_URL}console"
        }
    }
}
