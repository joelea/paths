write = require './model/write'

module.exports = ->
  pupil = document.getElementById('set-pupil').value
  score = document.getElementById('set-score').value
  write('/results/add', {pupil, score})
