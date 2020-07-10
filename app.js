const express = require('express');
const bodyParser = require('body-parser');
var formidable = require('formidable');

var app = express();

function FileContent(filename){
    console.log("fucks")
    var uploadFile = require("fs");
    uploadFile.readFile(filename,  (err, data) => {
        if (err) {
            console.log("err")
            return console.error(err);
        }
        console.log("I'm in!!!")
        console.log(data.toString());
    });
}

var urlencodeParser = bodyParser.urlencoded({extend: false});

app.set('view engine', 'ejs');
app.use('/assets', express.static('assets'));

app.get('/', function(req, res){
    res.render('info');
});

app.get('/contact', function(req, res){
    res.render('contact');
});

app.get('/register', function(req, res){
    res.render('register');
});

app.post('/register', urlencodeParser, function(req, res){
    console.log(req.body);
    res.render('register-success');

    var form = new formidable.IncomingForm();
    form.parse(req, function (err, fields, files) {
      var oldpath = files.filetoupload.path;
    console.log('oldpath' + oldpath);
      var newpath = './' + files.filetoupload.name;
      fs.rename(oldpath, newpath, function (err) {
        if (err) throw err;
        res.write('File uploaded!');
        res.end();
      });
 });
    // FileContent(req.body.fileUpload)
});

app.get('/profile/:name', function(req, res){
    var data = {
        name: "Trần Đức Mạnh",
        age: 18,
        uni: "UMASS Amherst",
        religion: "Viet Nam",
        hobbies: ['sleeping', 'playing']
    }
    res.render('profile', {name: req.params.name, data: data})
});

// app.get('/', function(req, res){
//     res.render('404');
// });

app.listen(3000);
