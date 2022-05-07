require('dotenv').config();

const Pool = require('pg').Pool
const pool = new Pool({
    dialect:'postgres',
    user: process.env.DB_USER,
    database:  process.env.DB_DATABASE,
    password: process.env.DB_PASSWORD,
    host: process.env.DB_HOST,
    port: process.env.DB_PORT
})

