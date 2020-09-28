import '@testing-library/jest-dom';
import { fireEvent, render } from '@testing-library/vue';
import routes from '../../src/routes';
import App from '../../src/App';
import Vuelidate from 'vuelidate';

describe('App.vue', () => {
    it('test navigation to overview', async () => {
        const { getByText, queryByText, queryByTestId } = setupComponent();

        await fireEvent.click(getByText('t-learn'));

        expect(
            queryByText('Übersicht aller Verstanstaltungen')
        ).toBeInTheDocument();
    });

    it('test navigation to create new course', async () => {
        const { getByText, queryByText } = setupComponent();

        await fireEvent.click(getByText('Erstellen'));

        expect(queryByText('Veranstaltung erstellen')).toBeInTheDocument();
    });

    function setupComponent() {
        return render(
            App,
            {
                routes: routes
            },
            localVue => {
                localVue.use(Vuelidate);
            }
        );
    }
});
