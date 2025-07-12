APP_FRONTEND_DIR=frontend
APP_BACKEND_DIR=backend

.PHONY: help start-frontend start-backend start-all

help:
	@echo ""
	@echo " * Available commands:"
	@echo " * start-frontend	- Starts the frontend (React/Next.js)"
	@echo " * start-backend	- Starts the backend (Spring Boot)"
	@echo " * start-all		- Starts both frontend and backend"
	@echo ""

start-frontend:
	@cd $(APP_FRONTEND_DIR) && npm install && npm run dev

start-backend:
	@cd $(APP_BACKEND_DIR) && mvn clean spring-boot:run

start-all:
	( make start-frontend & make start-backend )
