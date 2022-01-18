pipeline {
    agent {
        docker {
            label 'docker'
            image 'gradle:4.10.2-jdk8-alpine'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle --no-daemon clean build'
                stash includes: 'build/libs/*.jar', name: 'libs'
            }
        }
        stage('Deploy') {
            environment {
                REPOSILITE = credentials('reposilite')
            }
            when {
                branch 'master'
            }
            steps {
                unstash 'libs'
                sh "gradle --no-daemon -PreposiliteUsername=${REPOSILITE_USR} -PreposiliteToken=${REPOSILITE_PSW} publish"
            }
        }
    }
}