let mix = require('laravel-mix');
/*
 |--------------------------------------------------------------------------
 | Mix Asset Management
 |--------------------------------------------------------------------------
 |
 | Mix provides a clean, fluent API for defining some Webpack build steps
 | for your Laravel application. By default, we are compiling the Sass
 | file for the application as well as bundling up all the JS files.
 |
 */
mix.setPublicPath('../backend/src/main/resources/static');
mix.js('assets/js/main.js', '../backend/src/main/resources/static/js')
    .sass('assets/scss/main.scss', '../backend/src/main/resources/static/css');
