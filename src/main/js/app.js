import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.jsx';
import GenForm from './form.js';
import { Router, Route, hashHistory } from 'react-router';

ReactDOM.render(
	<Router history={hashHistory}>
		<Route path="/" component={ App } />
		<Route path="/form" component= { GenForm } />
	</Router>
	, document.getElementById('react')
);