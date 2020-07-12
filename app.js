const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
var exec = require('child_process').exec;
var execFile = require('child_process').execFile;


// Execute the java file and generate essay-converted.txt
var compileIt = 'cd TheGrammarChecker\\src\\proj5 && java Client.java';
function getConvertedFile(){
    exec(compileIt, function(error, stdout, stderr) {
        fs.writeFileSync("essay-converted.txt", stdout);
    });
}

var app = express();


var urlencodeParser = bodyParser.urlencoded({extend: false});

app.set('view engine', 'ejs');
app.use('/assets', express.static('assets'));

app.get('/', function(req, res){
    res.render('index');
});

app.post('/', urlencodeParser, function(req, res){
    // console.log(req.body.essay);
    fs.writeFileSync('./input.txt', req.body.essay); // viết file đây
    setTimeout(getConvertedFile, 2000);
    setTimeout(() => {
        var originalData = fs.readFileSync('input.txt', 'utf8');
        var convertedData = fs.readFileSync('essay-converted.txt', 'utf8');
        res.render('result', {ori: originalData, conv: convertedData});
    }, 4000);
});

app.get('/contact', function(req, res){
    res.render('contact');
});



app.listen(3000);
