{h} = require 'virtual-dom'

addResult = require './add-result'

module.exports = (results) ->
  h '.app', [
    h '.ete-add-results', [
      h 'input.ete-set-pupil#set-pupil', {type: 'text'}, ''
      h 'input.ete-set-score#set-score', {type: 'text'}, ''
      h 'button.ete-add-todo', { 'ev-click': addResult }, 'Add'
    ]
    h 'table.results', results.map (result) ->
      h 'tr.ete-result', [
        h 'td.ete-pupil', result.pupil
        h 'td.ete-score', result.score.toString()
      ]
  ]
