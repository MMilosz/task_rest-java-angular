pipeline {
	agent any
	tools {
	    maven 'Maven'
	}

	stages {
	    stage('Build') {
	        steps {
	            echo "Building"
	            sh 'mvn clean install'
	        }
	    }
	    
	    stage('Test') {
	        steps {
	            echo "Testing"
	            sh 'mvn test'
	        }

	    }
	    
	    stage('Deploy') {
	        steps {
	            echo "Deploying"
	        }

	    }



	}

}