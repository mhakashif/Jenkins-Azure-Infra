pipeline {
    agent {
        node {
            label 'jenkins'
        }
    }
    environment {
        AZURE_CLIENT_ID          = "1b4bca5b-hjbhbhd-askndbqkjd-hjbqdh-f78d593b58aa"
        AZURE_CLIENT_SECRET      = "IVG8Q~7yqhGyHfymXl~auyAV8rECDjeytwcGecc_"
        AZURE_TENANT_ID          = "52d0dcc1dshdcjsd-ffuflksd-shfjsh411901"
        AZURE_SUBSCRIPTION_ID    = "49b74460-fb8d-bhjwd-9jhbdewyug-8e3029c005c9"
        location                 = "centralus"
        resourceGroupname        = "rg-ibm-prod-01"
        storageactname           = "ksnbash435ernb245"
        vNetname                 = "vnet-prod-01"
        subnetName               = "sub-prod-01"
        addressPrefix            = "10.0.0.0/16"
        subnetPrefix             = "10.0.1.0/24"
    }
    stages {

        stage('Azure Login') {
            steps {
                script {
                    sh("az login --service-principal -u ${AZURE_CLIENT_ID} -p ${AZURE_CLIENT_SECRET} -t ${AZURE_TENANT_ID}")
                    sh("az account set --subscription ${AZURE_SUBSCRIPTION_ID}")
                }
            }
        }
        stage('Create a Resource Group') {
            steps {
                echo 'Creating a Resource Group'
                sh ("az group create --location ${location} --name ${resourceGroupname}")

            }
        }
        stage('Create a Storage Account') {
            steps {
                echo 'Creating a Storage Account'
                sh("az storage account create -n ${storageactname} -g ${resourceGroupname}  -l ${location} --sku Standard_LRS")
            }
        }
        stage('Create a vNet') {
            steps {
                echo 'Creating a vNet'
                sh("az network vnet create -g ${resourceGroupname} -n ${vNetname} --address-prefix ${addressPrefix} --subnet-name ${subnetName} --subnet-prefix ${subnetPrefix}")
            }
        }
    }
}