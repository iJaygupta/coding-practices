const express = require("express");
const app = express();
const bodyParser = require('body-parser');
app.use(bodyParser.json());
var mysql = require('mysql');

var conn = mysql.createConnection({
    host: "localhost",
    user: "username",
    password: "password",
    database: "dba_db_schema",
    port: 3306
});

conn.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
  });

app.get('/get-route', (req, res) => {
    console.log(req.query)
    res.send("testing get-route with query")
})

app.get('/get-route/:id', (req, res) => {
    console.log(req.params)
    res.send("testing get-route with params")
})

app.post('/post-route', (req, res) => {
    console.log(req.body)
    res.json({
        status: 200,
        data: "node app"
    });
})


app.listen(3000, () => {
    console.log("Server is up and running on port 3000")
})