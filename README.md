

# Quick Backend Deployment 🚀

This repository contains a very simple backend, ideal as a starting point for more complex projects. It includes a single `/health` endpoint that returns a basic response to verify the service is up and running.

## Workflow Diagram
 
![Quick backend deployment drawio](https://github.com/user-attachments/assets/629e7472-595c-47c1-9903-b03a0fad6690)


## ✨ Features

- Minimal backend with a `/health` endpoint  
- Automated deployment to AWS EC2 instances using:
  - Docker  
  - GitHub Actions  
  - GitHub Package Registry  
- Simple and scalable CI/CD workflow

##🖥️ AWS Requirements
- EC2 with docker, docker compose installed.
- AWS credentials with EC2FullAccess policy.
- Set inbound rules to allow Http, Https and SSH trafic.

## 🧱 Project Structure
``` 
  Backend/ 
  ├── .github/ 
  │ └── workflows/ 
  │ └── ci.yaml
  └── Deploy
    └── docker-compose.yaml
  └── src/...(backend code)
  └── Dockerfile
```

> It's important to keep this structure so GitHub Actions can correctly detect and run the CI/CD workflows.

## 🔐 Environment Configuration

For security, you must create an *Environment* inside the repository (e.g., `DEV`) and store all required secrets there, such as:

- `AWS_ACCESS_KEY_ID`  
- `AWS_SECRET_ACCESS_KEY`  
- `EC2_PRIVATE_KEY`  
- `GH_TOKEN` (if needed)  
- Other environment variables like `EC2_HOST`, `IMAGE_NAME`, `SERVER_PORT`, `JWT_TOKEN`, etc.

Also, remeber to configure the permissions of your github actions:
![image](https://github.com/user-attachments/assets/20b7a917-cd0c-40e6-b0dd-5c262427b83c)


## ✅ Best Practices

- Set up **branch protection rules** to avoid direct pushes to `main`.  
- Review and restrict who can approve and merge pull requests.  
- Create a separate environment for production (`PROD`) with similar security settings.  
- Add **unit test checks** before building and pushing the Docker image.

## 🧪 Test Endpoint

You can verify that the backend is running correctly using the following endpoint:
GET /health

Expected output:
```json
{
    "timestamp": "2025-05-20T17:25:33.908210700Z",
    "status": 200,
    "message": "Petición exitosa",
    "data": "Backend is running perfectly."
}

