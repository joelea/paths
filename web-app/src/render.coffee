{h} = require 'virtual-dom'

module.exports = (results) ->
  h '.app', [
    h '.ete-add-results', [
      h 'input.ete-set-pupil', {type: 'text'}, ''
      h 'input.ete-set-score', {type: 'text'}, ''
      h 'button.ete-add-todo', 'Add'
    ]
    h '.results', results.map (result) ->
      h '.ete-result', [
        h '.ete-pupil', result.pupil
        h '.ete-score', result.score.toString()
      ]
  ]
