$ = require 'jquery'

module.exports = (url, body) ->
  $.ajax(
    type: "POST"
    url: url
    data: JSON.stringify(body)
  )