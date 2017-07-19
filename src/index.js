import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter } from 'react-router-dom'
import { Provider } from 'react-redux'
import { createStore } from 'redux'

function WhereThingsHappened() {
  return (
  	<BrowserRouter>
		<App />		
    </BrowserRouter>
  );
}

ReactDOM.render(<WhereThingsHappened />, document.getElementById('root'));
registerServiceWorker();
