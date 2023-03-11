Project Description

This project is a Jenkins pipeline that creates an Azure resource group, storage account, and virtual network.

Prerequisites
Jenkins installed and running
Azure account
Azure CLI installed on Jenkins node
Pipeline Steps
Azure Login: Login to Azure using the service principal created with the credentials specified in the Jenkins environment variables.
Create a Resource Group: Create an Azure resource group with the specified name and location.
Create a Storage Account: Create an Azure storage account with the specified name, location, and SKU.
Create a vNet: Create an Azure virtual network with the specified name, address prefix, and subnet.
Environment Variables

The following environment variables must be set in Jenkins:
AZURE_CLIENT_ID: Azure service principal client ID
AZURE_CLIENT_SECRET: Azure service principal client secret
AZURE_TENANT_ID: Azure tenant ID
AZURE_SUBSCRIPTION_ID: Azure subscription ID
location: Azure location to create resources in
resourceGroupname: Azure resource group name
storageactname: Azure storage account name
vNetname: Azure virtual network name
subnetName: Azure virtual network subnet name
addressPrefix: Azure virtual network address prefix
subnetPrefix: Azure virtual network subnet prefix

Usage
Create a Jenkins job with the pipeline script.
Configure the environment variables in the Jenkins job configuration.
Run the Jenkins job to create the Azure resources.
Author
MOHD ABDUL KASHIF 
