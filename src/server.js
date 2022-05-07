require("dotenv").config();
const cors = require("cors");
const express = require("express");
const bodyParser = require("body-parser");
const PORT = process.env.PORT || 8080;
const app = express();
const db = require("./models");

var corsOptions = { origin: "https://localhost:7000" };

app.use(cors(corsOptions));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get("/", (req, res) => {
  res.json({ message: "Welcome to MovieLand application" });
  res.status(200).send("status 200");
});

require("./routes/routes")(app);

await db.sequelize.sync();
app.listen(PORT, () => console.log(`Server started on port @{PORT}`));

// const start = async () => {
//   try {
//     await db.sequelize.authenticate();
//     await db.sequelize.sync();
//     app.listen(PORT, () => console.log(`Server started on port @{PORT}`));
//   } catch (e) {
//     console.log(e);
//   }
// };
// start();
