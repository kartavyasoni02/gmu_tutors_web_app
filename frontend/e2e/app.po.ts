import { browser, by, element } from 'protractor';

export class FrontendPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('gmu-root h1')).getText();
  }
}
