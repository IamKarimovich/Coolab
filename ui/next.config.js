/** @type {import('next').NextConfig} */
module.exports = {
  trailingSlash: true,
  async rewrites() {
      return [
        {
          source: '/api/:path*/',
          destination: 'http://localhost:8080/api/:path*/',
        },
      ]
    },
};