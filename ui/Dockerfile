# Use the official Node.js 20 Docker image as the base image
FROM node:20

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files into the container
COPY package*.json ./

# Install the Node.js dependencies
RUN npm install --timeout=300000

# Copy the rest of the application code into the container
COPY . .

# Build the Next.js application
RUN npm run build

# Expose the port on which your Next.js application listens
EXPOSE 3000

# Define the command to run your application
CMD ["npm", "start"]
