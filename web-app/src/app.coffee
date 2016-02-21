Bacon = require 'baconjs'
{h} = require 'virtual-dom'
attach = require 'bacon-dom'
write = require './model/write'
stream = require './model/stream'
render = require './render'

DomDelegator = require 'dom-delegator'
domDelegator = new DomDelegator()

model = stream("/results/all")
model.log()

html = model.map(render)
rootElement = document.getElementById('app')
attach(html).to(rootElement)
