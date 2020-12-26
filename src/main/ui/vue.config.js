module.exports = {
  devServer: {
    proxy: {
      '^/birthdayreminder/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
    }
  }
}