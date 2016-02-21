Bacon = require 'baconjs'
{h} = require 'virtual-dom'
attach = require 'bacon-dom'
write = require './model/write'
stream = require './model/stream'

DomDelegator = require 'dom-delegator'
domDelegator = new DomDelegator()

html = model.map(render)
rootElement = document.getElementById('app')
attach(html).to(rootElement)
