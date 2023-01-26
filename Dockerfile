FROM node:18-alpine
WORKDIR /dockerReactTest
COPY . .
RUN npm install
RUN npm run build
ENV NODE_ENV production
EXPOSE 3001
CMD ["node", "server.js"]