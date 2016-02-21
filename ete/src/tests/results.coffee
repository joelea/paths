module.exports =
  'add a result' : (browser) ->
    browser
      .url('http://entry')
      .waitForElementVisible('.ete-add-results')
      .setValue('.ete-set-pupil', 'Joe')
      .setValue('.ete-set-score', '90')
      .waitForElementVisible('.ete-result')
      .click('.ete-add-todo')

    browser.expect.element('.ete-result .ete-pupil').text
      .to.equal('Joe')
      .before(5000)

    browser.expect.element('.ete-result .ete-score').text
      .to.equal('90')
      .before(5000)
