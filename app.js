const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
var exec = require('child_process').exec;


// Đây là để execute file java đây
var compileIt = 'java ./src/proj5/Client.java';

exec(compileIt, function(error, stdout, stderr) {
    console.log(stdout);
});


var app = express();


var urlencodeParser = bodyParser.urlencoded({extend: false});

app.set('view engine', 'ejs');
app.use('/assets', express.static('assets'));

app.get('/', function(req, res){
    res.render('index');
});

app.post('/', urlencodeParser, function(req, res){
    // console.log(req.body.essay);
    fs.writeFileSync('./output.txt', req.body.essay);
    res.render('register-success');
});

app.get('/contact', function(req, res){
    res.render('contact');
});

    

app.listen(3000);
