function fn() {
    var env = karate.env || 'dev';

    var config = {
        env: env,
        baseUrl: karate.properties['baseUrl'] || 'https://api.demoblaze.com'
    };

    karate.log('ENV:', env);
    karate.log('baseUrl:', config.baseUrl);

    return config;
}
