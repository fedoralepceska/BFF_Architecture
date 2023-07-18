import { createRouter, createWebHistory } from 'vue-router';

// Import your components here
import HomePage from './components/Home.vue';

const routes = [
    // Define your routes here
    {
        path: '/',
        name: 'Home',
        component: HomePage,
    },
    // Add more routes for other components as needed
];

const router = createRouter({
    history: createWebHistory(), // This enables history mode
    routes,
});

export default router;
