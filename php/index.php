<?php
require 'vendor/autoload.php';

$app = new \Slim\Slim();

$app->get('/service/checks', function () {
    echo "This is all of our checks";
});

$app->get('/service/checks/:id', function ($id) {
    echo "This is check ".$id;
});

$app->get('/service/checks/:id/status', function ($id) {
    echo "This is the status of check ".$id;
});

$app->get('/service/checks/:id/execute', function ($id) {
    echo "Executing check ".$id;
});

$app->post('/service/checks/add', function () {
    echo "Adding a new check";
});

$app->put('/service/checks/:id', function ($id) {
    echo "Updating check ".$id;
});

$app->run();