npx create-react-app shop
cd shop
npm install -g npm@8.9.0
npm i @material-ui/core @material-ui/icons @chec/commerce.js @stripe/react-stripe-js @stripe/stripe-js react-router-dom react-hook-form
npm run build
heroku login
heroku create web-store-react
npm i -g heroku
git remote -v
git add .
git commit -m "init"
git push heroku master
